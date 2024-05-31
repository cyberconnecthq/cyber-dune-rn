import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, ActivityIndicator } from 'react-native';
import { Provider, ethers } from 'ethers';


const GasFeeWidget: React.FC = () => {
    const [gasPrice, setGasPrice] = useState<string | null>(null);
    const [loading, setLoading] = useState<boolean>(true);
  
    useEffect(() => {
      const fetchGasPrice = async () => {
          try {
              // 使用 ethers 提供的默认提供程序
              const provider: Provider = ethers.getDefaultProvider('mainnet');
              const gasPrice = (await provider.getFeeData()).gasPrice;
              // 将 gasPrice 转换为 Gwei
              setGasPrice(ethers.formatUnits(gasPrice ?? 0, 'gwei'));
              setLoading(false);
          } catch (error) {
              console.error('Error fetching gas price:', error);
              setLoading(false);
          }
      };
  
      fetchGasPrice();
    }, []);
  
    if (loading) {
      return (
        <View style={styles.container}>
          <ActivityIndicator size="large" color="#00ff00" />
        </View>
      );
    }
  
    return (
      <View style={styles.container}>
        <Text style={styles.text}>{gasPrice} Gwei</Text>
      </View>
    );
  };
  

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: '#f5f5f5',
      padding: 20,
      margin: 20,
      borderRadius: 10,
      shadowColor: '#000',
      shadowOffset: { width: 0, height: 2 },
      shadowOpacity: 0.8,
      shadowRadius: 2,
      elevation: 1,
    },
    text: {
      fontSize: 18,
      color: '#333',
    },
  });
  
  export default GasFeeWidget;