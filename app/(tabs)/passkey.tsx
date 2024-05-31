import React from 'react';
import CyberPasskeyModule from '@/modules/cyber-passkey/src/CyberPasskeyModule';
import { StyleSheet, Text, View, Button, Platform } from 'react-native';

const App: React.FC = () => {
  const handlePress = () => {
    console.log('Button was pressed!');
    if (Platform.OS === 'android') { 
        CyberPasskeyModule.startActivity();
    }

  };

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Press the button below:</Text>
      <Button title="Press Me" onPress={handlePress} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 18,
    marginBottom: 20,
  },
});

export default App;
