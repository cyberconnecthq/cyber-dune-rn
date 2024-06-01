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
            <View style={styles.loadingContainer}>
                <ActivityIndicator size="large" color="#0000ff" />
            </View>
        );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Current Gas Fee</Text>
            <Text style={styles.text}>{gasPrice} Gwei</Text>
        </View>
    );
};

const styles = StyleSheet.create({
    loadingContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f5f5f5',
    },
    container: {
        backgroundColor: '#f0fff0', // Honeydew
        padding: 20,
        borderRadius: 16,
        margin: 20,
        alignItems: 'center',
        justifyContent: 'center',
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5,
        borderWidth: 2,
        borderColor: '#2E8B57', // SeaGreen
    },
    title: {
        fontSize: 20,
        fontWeight: 'bold',
        color: '#2E8B57', // SeaGreen
        marginBottom: 10,
    },
    text: {
        fontSize: 24,
        color: '#006400', // DarkGreen
    },
});

export default GasFeeWidget;
