import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View, ScrollView, ActivityIndicator, SafeAreaView, StatusBar, Dimensions } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';
import { MaterialIcons, FontAwesome5 } from '@expo/vector-icons';
import { LineChart, PieChart } from 'react-native-chart-kit';
import * as Linking from 'expo-linking';
import { Link, router, Navigator, Tabs } from 'expo-router';

const screenWidth = Dimensions.get('window').width;

interface ChartData {
  labels?: string[];
  datasets?: {
    data: number[];
    color: (opacity?: number) => string;
  }[];
}

interface PieChartData {
  name: string;
  population: number;
  color: string;
  legendFontColor: string;
  legendFontSize: number;
}

interface DashboardData {
  title: string;
  value: number;
  description: string;
  chartData?: ChartData | PieChartData[];
}

interface MockData {
  dashboard1: DashboardData;
  dashboard2: DashboardData;
  dashboard3: DashboardData;
}

const mockData: MockData = {
  dashboard1: {
    title: "Total Transactions(Mocked)",
    value: 10234,
    description: "Number of transactions processed.",
    chartData: {
      labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"],
      datasets: [
        {
          data: [20, 45, 28, 80, 99, 43],
          color: (opacity = 1) => `rgba(134, 65, 244, ${opacity})`,
        }
      ]
    }
  },
  dashboard2: {
    title: "Active Nodes(Mocked)",
    value: 245,
    description: "Number of active nodes in the network.",
    chartData: [
      { name: 'Node A', population: 40, color: 'rgba(131, 167, 234, 1)', legendFontColor: '#7F7F7F', legendFontSize: 15 },
      { name: 'Node B', population: 30, color: '#F00', legendFontColor: '#7F7F7F', legendFontSize: 15 },
      { name: 'Node C', population: 20, color: 'rgb(0, 0, 255)', legendFontColor: '#7F7F7F', legendFontSize: 15 },
      { name: 'Node D', population: 10, color: '#0f0', legendFontColor: '#7F7F7F', legendFontSize: 15 },
    ]
  },
  dashboard3: {
    title: "Block Height(Mocked)",
    value: 673234,
    description: "Current block height of the blockchain."
  }
};

interface DashboardProps {
  title: string;
  value: number;
  description: string;
  chartData?: ChartData | PieChartData[];
  chartType?: 'line' | 'pie';
  icon: React.ReactNode;
}

const Dashboard: React.FC<DashboardProps> = ({ title, value, description, chartData, chartType, icon }) => (
  <View style={styles.dashboard}>
    <View style={styles.dashboardHeader}>
      {icon}
      <Text style={styles.dashboardTitle}>{title}</Text>
    </View>
    <Text style={styles.dashboardValue}>{value}</Text>
    <Text style={styles.dashboardDescription}>{description}</Text>
    {chartData && chartType === 'line' && (
      <LineChart
        data={chartData as ChartData}
        width={screenWidth * 0.8}
        height={220}
        chartConfig={chartConfig}
        bezier
        style={styles.chart}
      />
    )}
    {chartData && chartType === 'pie' && (
      <PieChart
        data={chartData as PieChartData[]}
        width={screenWidth * 0.8}
        height={220}
        chartConfig={chartConfig}
        accessor="population"
        backgroundColor="transparent"
        paddingLeft="15"
        absolute
        style={styles.chart}
      />
    )}
  </View>
);

const chartConfig = {
  backgroundGradientFrom: '#ffffff',
  backgroundGradientTo: '#ffffff',
  color: (opacity = 1) => `rgba(46, 139, 87, ${opacity})`, // SeaGreen
  labelColor: (opacity = 1) => `rgba(0, 0, 0, ${opacity})`,
  strokeWidth: 2,
  barPercentage: 0.5,
};

const Mocked: React.FC = () => {
  const [data, setData] = useState<MockData | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        await new Promise(resolve => setTimeout(resolve, 1000));
        setData(mockData);
      } catch (error) {
        console.error("Error fetching data:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  if (loading) {
    return (
      <SafeAreaView style={styles.mainContainer}>
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" color="#2ecc71" />
        </View>
      </SafeAreaView>
    );
  }

  return (
    <SafeAreaView style={styles.mainContainer}>
      <ScrollView contentContainerStyle={styles.container}>
        {data ? (
          <>
            <Dashboard 
              title={data.dashboard1.title} 
              value={data.dashboard1.value} 
              description={data.dashboard1.description} 
              chartData={data.dashboard1.chartData}
              chartType="line"
              icon={<MaterialIcons name="show-chart" size={24} color="#2ecc71" style={styles.icon} />}
            />
            <Dashboard 
              title={data.dashboard2.title} 
              value={data.dashboard2.value} 
              description={data.dashboard2.description} 
              chartData={data.dashboard2.chartData}
              chartType="pie"
              icon={<FontAwesome5 name="network-wired" size={24} color="#2ecc71" style={styles.icon} />}
            />
            <Dashboard 
              title={data.dashboard3.title} 
              value={data.dashboard3.value} 
              description={data.dashboard3.description}
              icon={<MaterialIcons name="height" size={24} color="#2ecc71" style={styles.icon} />}
            />
          </>
        ) : (
          <Text style={styles.errorText}>Failed to load data</Text>
        )}
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  mainContainer: {
    flex: 1,
    backgroundColor: '#f5f5f5',
  },
  container: {
    flexGrow: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 20,
  },
  loadingContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  dashboard: {
    width: screenWidth * 0.9,
    backgroundColor: '#f0fff0', // Honeydew
    padding: 20,
    borderRadius: 15,
    marginVertical: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 3 },
    shadowOpacity: 0.1,
    shadowRadius: 8,
    elevation: 5,
    borderWidth: 2,
    borderColor: '#2E8B57', // SeaGreen
  },
  dashboardHeader: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 10,
  },
  icon: {
    marginRight: 10,
  },
  dashboardTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    color: '#2E8B57', // SeaGreen
  },
  dashboardValue: {
    fontSize: 36,
    fontWeight: 'bold',
    color: '#006400', // DarkGreen
    marginBottom: 10,
  },
  dashboardDescription: {
    fontSize: 16,
    color: '#7f8c8d',
  },
  chart: {
    marginVertical: 10,
    borderRadius: 16,
  },
  errorText: {
    fontSize: 18,
    color: 'red',
  },
});

export default Mocked;
