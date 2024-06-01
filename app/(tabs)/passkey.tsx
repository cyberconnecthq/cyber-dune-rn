import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View, Image, ScrollView, Platform } from 'react-native';
import CyberPasskeyModule from '@/modules/cyber-passkey/src/CyberPasskeyModule';

const App: React.FC = () => {
  const [user, setUser] = useState<any>(null);
  const [balances, setBalances] = useState<any[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      const eoa = CyberPasskeyModule.getEOA();
      const avatar = CyberPasskeyModule.getAvatar();
      if (typeof eoa === 'string' && typeof avatar === 'string') {
        console.log('eoa:', eoa);
        const userData = {
          name: 'User',
          avatar: avatar,
          totalBalance: 1000,
          address: eoa,
        };
        setUser(userData);

        const chainBalances = [
          { chain: 'ETH', balance: 500 },
          { chain: 'BTC', balance: 300 },
          { chain: 'EOS', balance: 200 },
        ];
        setBalances(chainBalances);
      } else {
        if (Platform.OS === 'android') {
          console.log('Start activity');
          CyberPasskeyModule.startActivity();
        } else {
          CyberPasskeyModule.presentPasskeyViewController();
        }
      }
    };

    fetchData();
  }, []);

  return (
    <ScrollView contentContainerStyle={styles.container}>
      {user && (
        <View style={styles.card}>
          <View style={styles.header}>
            <Image source={{ uri: user.avatar }} style={styles.avatar} />
            <View style={styles.userInfo}>
              <Text style={styles.userName}>{user.name}</Text>
              <Text style={styles.address}>Address: {user.address}</Text>
              <Text style={styles.totalBalance}>Total Balance: {user.totalBalance}</Text>
            </View>
          </View>
        </View>
      )}
      {balances.length > 0 && (
        <View style={styles.form}>
          <Text style={styles.title}>Your Balances</Text>
          {balances.map((item, index) => (
            <View key={index} style={styles.balanceItem}>
              <Text style={styles.chainName}>{item.chain}</Text>
              <Text style={styles.balance}>Balance: {item.balance}</Text>
            </View>
          ))}
        </View>
      )}
    </ScrollView>
  );
}
  
  const styles = StyleSheet.create({
    container: {
      flexGrow: 1,
      backgroundColor: '#FFFFFF',
      alignItems: 'center',
      justifyContent: 'center',
    },
    card: {
      width: '80%',
      backgroundColor: '#F0FFF0', // Light green background
      borderRadius: 20,
      padding: 20,
      marginBottom: 20,
    },
    header: {
      flexDirection: 'row',
      alignItems: 'center',
    },
    avatar: {
      width: 100,
      height: 100,
      borderRadius: 50,
      marginRight: 20,
    },
    userInfo: {
      flex: 1,
    },
    userName: {
      fontSize: 24,
      fontWeight: 'bold',
      color: '#008000', // Green text
      marginBottom: 5,
    },
    address: {
      fontSize: 14,
      color: '#808080', // Grey text
    },
    totalBalance: {
      fontSize: 18,
      color: '#808080', // Grey text
    },
    form: {
      width: '80%',
    },
    title: {
      fontSize: 20,
      fontWeight: 'bold',
      color: '#008000', // Green text
      marginBottom: 10,
    },
    balanceItem: {
      marginBottom: 10,
    },
    chainName: {
      fontSize: 16,
      fontWeight: 'bold',
      color: '#000000', // Black text
    },
    balance: {
      fontSize: 14,
      color: '#808080', // Grey text
    },
  });

export default App;
