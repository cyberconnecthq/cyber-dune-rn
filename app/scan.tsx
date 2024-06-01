import React from 'react';
import { View, Image, StyleSheet } from 'react-native';

const CenteredImageScreen = () => {
  return (
    <View style={styles.container}>
      <Image
        source={require('../assets/images/code.jpg')}
        style={styles.image}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  image: {
    width: 200,  // 根据需要调整宽度
    height: 200, // 根据需要调整高度
    resizeMode: 'contain', // 保持图片比例
  },
});

export default CenteredImageScreen;
