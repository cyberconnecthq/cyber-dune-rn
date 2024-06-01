import React, { useEffect, useState } from 'react';
import { View, Text, Dimensions, StyleSheet, ActivityIndicator, SafeAreaView, ScrollView } from 'react-native';
import { PieChart, LineChart } from 'react-native-chart-kit';
import { axiosGetRtxNumber, axiosGetTxNumber } from '../../components/network';
import { TxData, RestakeData } from '../../components/dataType';
import * as Linking from 'expo-linking';
import { router } from 'expo-router';

const screenWidth = Dimensions.get('window').width;

const convertUTCToTime = (dateString: string) => {
  const trimmedDateString = dateString.split('.')[0].replace(' UTC', '');
  const date = new Date(trimmedDateString);
  const hours = date.getUTCHours().toString().padStart(2, '0');
  const minutes = date.getUTCMinutes().toString().padStart(2, '0');
  return `${hours}:${minutes}`;
};

const timeStringToMinutes = (timeString: string) => {
  const [hours, minutes] = timeString.split(':').map(Number);
  return hours * 60 + minutes;
};

const LineChartComponent = () => {
  const [txData, setTxData] = useState<TxData[]>([]);
  const [rstData, setRstData] = useState<RestakeData[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [stRes, rstRes] = await Promise.all([
          axiosGetTxNumber(),
          axiosGetRtxNumber()
        ]);
        const sortedStRes = stRes.sort((a: TxData, b: TxData) => 
          timeStringToMinutes(convertUTCToTime(a.block_hour)) - timeStringToMinutes(convertUTCToTime(b.block_hour)));
        setTxData(sortedStRes);
        setRstData(rstRes);
      } catch (error) {
        setError('');
      } finally {
        setLoading(false);
      }
    };
    fetchData();

    const getInitialUrl = async () => {
      const initialUrl = await Linking.getInitialURL();
      handleUrl({ url: initialUrl });
    };
    getInitialUrl();
  
    const handleUrl = async (event: any) => {
      console.log('Received URL:', event);
      const { url } = event;
      if (url) {
        console.log('Received URL:', url);
        if (url.includes('cyberDune://login')) {
          router.replace('./explore');
        } else if (url.includes('cyberDune://dashboard')) {
          router.replace('./index');
        } else {
          console.log('invalid url', url);
        }
      }
    }
  
    Linking.addEventListener('url', handleUrl);
  }, []);

  if (loading) {
    return (
      <View style={styles.container}>
        <ActivityIndicator size="large" color="#0000ff" />
      </View>
    );
  }

  if (error) {
    return (
      <View style={styles.container}>
        <Text>Error: {error}</Text>
      </View>
    );
  }

  const chartData = {
    labels: txData.map((item) => convertUTCToTime(item.block_hour)),
    datasets: [
      {
        data: txData.map((item: any) => item.amount_staked_total),
      },
    ],
  };

  const pieData = [
    {
      name: 'BNB',
      count: txData[0].cumulative_num_stake_bnb * 600,
      color: '#006400',
      legendFontColor: '#7F7F7F',
      legendFontSize: 15,
    },
    {
      name: 'ETH',
      count: txData[0].cumulative_num_stake_ethereum * 3800,
      color: '#32CD32',
      legendFontColor: '#7F7F7F',
      legendFontSize: 15,
    },
    {
      name: 'OP',
      count: txData[0].cumulative_num_stake_optimism * 2.5,
      color: '#228B22',
      legendFontColor: '#7F7F7F',
      legendFontSize: 15,
    },
  ];

  return (
    <SafeAreaView style={styles.safeArea}>
      <ScrollView>
        <View style={styles.container}>
          <View style={styles.boxContainer}>
            <View style={styles.box}>
              <Text style={styles.boxText}>Total Staked Cyber</Text>
              <Text style={styles.boxValue}>{txData[0].cumulative_amount_staked_total.toFixed(2)}</Text>
            </View>
            <View style={styles.box}>
              <Text style={styles.boxText}>Total Restaked Cyber</Text>
              <Text style={styles.boxValue}>{rstData[0].cumulative_net_amount_restaked_total.toFixed(2)}</Text>
            </View>
          </View>
          <View style={styles.chartContainer}>
            <Text style={styles.chartTitle}>Stake By Hour</Text>
            <LineChart
              data={chartData}
              width={screenWidth - 60} // Adjusted for padding
              height={220}
              yAxisLabel=""
              yAxisSuffix="K"
              yAxisInterval={1}
              chartConfig={{
                backgroundColor: '#ffffff',
                backgroundGradientFrom: '#ffffff',
                backgroundGradientTo: '#ffffff',
                decimalPlaces: 2,
                color: (opacity = 1) => `rgba(46, 139, 87, ${opacity})`, // MediumSeaGreen
                labelColor: (opacity = 1) => `rgba(0, 0, 0, ${opacity})`,
                style: {
                  borderRadius: 16,
                },
                propsForDots: {
                  r: '6',
                  strokeWidth: '2',
                  stroke: '#2E8B57', // SeaGreen
                },
              }}
              bezier
              style={styles.chart}
            />
          </View>
          <View style={styles.chartContainer}>
            <Text style={styles.chartTitle}>Stake Distribution (Total)</Text>
            <PieChart
              data={pieData}
              width={screenWidth - 60} // Adjusted for padding
              height={220}
              chartConfig={{
                backgroundColor: '#ffffff',
                backgroundGradientFrom: '#ffffff',
                backgroundGradientTo: '#ffffff',
                color: (opacity = 1) => `rgba(0, 0, 0, ${opacity})`,
              }}
              accessor="count"
              backgroundColor="transparent"
              paddingLeft="15"
              absolute // Display percentage values
              style={styles.chart}
            />
            <View style={styles.legendContainer}>
              {pieData.map((data, index) => (
                <View key={index} style={styles.legendItem}>
                  <Text style={styles.legendName}>{data.name}</Text>
                  <Text style={styles.legendCount}>${data.count}</Text>
                </View>
              ))}
            </View>
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

  const styles = StyleSheet.create({
    safeArea: {
      flex: 1,
      backgroundColor: '#ffffff',
    },
    container: {
      flex: 1,
      alignItems: 'center',
      justifyContent: 'center',
      padding: 20,
    },
    chartContainer: {
      width: screenWidth - 40,
      padding: 20,
      marginBottom: 20,
      borderRadius: 16,
      borderWidth: 2,
      borderColor: '#2E8B57', // SeaGreen
      backgroundColor: '#f0fff0', // Honeydew
      alignItems: 'center',
      elevation: 5, // Shadow
    },
    chartTitle: {
      fontSize: 20,
      fontWeight: 'bold',
      color: '#2E8B57', // SeaGreen
      marginBottom: 10,
    },
    boxContainer: {
      flexDirection: 'row',
      justifyContent: 'space-between',
      marginTop: 30,
      marginBottom: 20,
      width: screenWidth - 20,
    },
    box: {
      backgroundColor: '#f0fff0', // Honeydew
      padding: 20,
      borderRadius: 10,
      margin: 10,
      alignItems: 'center',
      shadowColor: '#000',
      shadowOffset: {
        width: 0,
        height: 2,
      },
      shadowOpacity: 0.25,
      shadowRadius: 3.84,
      elevation: 5,
      flex: 1,
    },
    boxText: {
      fontSize: 18,
      fontWeight: 'bold',
      color: '#2E8B57', // SeaGreen
    },
    boxValue: {
      fontSize: 24,
      marginTop: 5,
      color: '#006400', // DarkGreen
    },
    legendContainer: {
      flexDirection: 'row',
      flexWrap: 'wrap',
      justifyContent: 'center',
      marginTop: 10,
    },
    legendItem: {
      flexDirection: 'row',
      alignItems: 'center',
      marginHorizontal: 10,
      marginVertical: 5,
    },
    legendName: {
      fontSize: 16,
      color: '#333333',
      marginRight: 5,
    },
    legendCount: {
      fontSize: 16,
      color: '#2E8B57', // SeaGreen
      fontWeight: 'bold',
    },
    chart: {
      marginVertical: 8,
      borderRadius: 16,
    },
  });
  

export default LineChartComponent;