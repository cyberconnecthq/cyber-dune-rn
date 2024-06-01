package com.cyberconnnect.link3.utils

import android.text.TextUtils
import com.cyberconnnect.link3.ApolloClient
import com.cyberconnnect.link3.fragment.Price
import com.cyberconnnect.link3.utils.decodeHex
import com.cyberconnnect.link3.viewmodel.ApplicationViewModel
import org.web3j.abi.FunctionEncoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.DynamicBytes
import org.web3j.abi.datatypes.StaticStruct
import org.web3j.abi.datatypes.Utf8String
import org.web3j.abi.datatypes.generated.Bytes32
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.abi.datatypes.generated.Uint8
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.request.Transaction
import org.web3j.protocol.core.methods.response.EthCall
import org.web3j.protocol.core.methods.response.EthGetBalance
import org.web3j.protocol.websocket.WebSocketService
import org.web3j.utils.Convert
import timber.log.Timber


object Web3Util {
    const val BSC_CHAIN_ID = 56
//    const val WALLET_BRIDGE = "wss://bridge.walletconnect.org"
    const val WALLET_BRIDGE = "wss://relay.walletconnect.com?projectId=787920515535b0c17988d383680d9b0d"
    const val LINK3_URI = "https://link3.to"

    const val NODE = "wss://rpc.cyber.co"
    const val NODE_GOERLI = "wss://optimism-goerli.infura.io/ws/v3/0fd2d9bce2e5471baa7dad9d59730e1d"
    const val NODE_SEPOLIA = "wss://optimism-sepolia.infura.io/ws/v3/0fd2d9bce2e5471baa7dad9d59730e1d"
    const val OP_USDT_ADDRESS = "0x94b008aa00579c1307b0ef2c499ad98a8ce58e58"
    const val OP_USDT_ADDRESS_GOERLI = "0x32307adfFE088e383AFAa721b06436aDaBA47DBE"
    const val OP_USDT_ADDRESS_SEPOLIA = "0x5fd84259d66Cd46123540766Be93DFE6D43130D7"
    val USDT_ADDRESS = if (ApolloClient.debug) OP_USDT_ADDRESS_SEPOLIA else OP_USDT_ADDRESS
    val BALANCE_CONVERT_UNIT = if (ApolloClient.debug) Convert.Unit.MWEI else Convert.Unit.MWEI

    val OP_CHAIN_ID = if (ApolloClient.debug) 11155420 else 10

    val CC_PROFILE_CONTRACT_ADDRESS = mapOf(
        56 to "0x2723522702093601e6360cae665518c4f63e9da6",
        97 to "0x57e12b7a5f38a7f9c23ebd0400e6e53f2a45f271",
        137 to "0xbF029d040e3E6DA7b768b759dD9D67D84c73C06f",
        5 to "0x57e12b7a5f38a7f9c23ebd0400e6e53f2a45f271"
    )

    val RAFFLE_CONTRACT_ADDRESS = mapOf(
        56 to "0xdd2ec94890e2d92e131a89f73bfe124137e0c10e",
        97 to "0x5e2a433774a51207d69bb432898b3626e20cda66",
        5 to "0x5e2a433774a51207d69bb432898b3626e20cda66",
        1 to "0xdd2ec94890e2d92e131a89f73bfe124137e0c10e",
        137 to "0xdd2ec94890e2d92e131a89f73bfe124137e0c10e",
        )

    val chainInfo = mapOf(
        BSC_CHAIN_ID to mapOf(
            "chainId" to "0x38",
            "chainName" to "Binance Smart Chain",
            "rpcUrls" to arrayOf("https://bsc-dataseed.binance.org"),
            "nativeCurrency" to mapOf("name" to "BNB", "symbol" to "BNB", "decimals" to 18),
            "blockExplorerUrls" to arrayOf("https://bscscan.com")
        )
    )

    val paidConfig = listOf(
        mapOf(
            "symbol" to "USDT",
            "contractAddress" to "0x55d398326f99059ff775485246999027b3197955"
        ),
        mapOf(
            "symbol" to "USDC",
            "contractAddress" to "0x8ac76a51cc950d9822d68b83fe1ad97b32cd580d"
        ),
        mapOf(
            "symbol" to "BUSD",
            "contractAddress" to "0xe9e7cea3dedca5984780bafc599bd69add087d56"
        ),
        mapOf(
            "symbol" to "USDT",
            "contractAddress" to "0x337610d27c682e347c9cd60bd4b3b107c9d34ddd"
        ),
    )

    fun createCollectCallMessage(collector: String, profileId: Long, essenceId: Long, preData: String): String {
        val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
            "collect",
            listOf(StaticStruct(listOf(Address(collector), Uint256(profileId), Uint256(essenceId))), DynamicBytes(if (TextUtils.isEmpty(preData)) "".toByteArray() else preData.substring(2).decodeHex()), DynamicBytes("".toByteArray())), listOf(object : TypeReference<Uint256>() {}))
        return FunctionEncoder.encode(function)
    }

    fun createClaimRaffleMessage(collector: String, profileId: String, currency: String, amount: String, signature: String, deadline: String): String {
        val r = if (signature.length == 132) Bytes32(signature.substring(2, 66).decodeHex()) else Bytes32("00".decodeHex())
        val s = if (signature.length == 132) Bytes32(signature.substring(66, 130).decodeHex()) else Bytes32("00".decodeHex())
        val v = if (signature.length == 132) {
            if (signature.takeLast(2) == "1b") Uint8(27) else Uint8(28)
        } else Uint8(0)
        val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
            "claim",
            listOf(Utf8String(profileId), Address(collector), Address(currency), Uint256(amount.toBigInteger()),
                StaticStruct(listOf(v, r, s, Uint256(deadline.toLong())))), listOf(object : TypeReference<Uint256>() {}))
        return FunctionEncoder.encode(function)
    }

    fun convertApproveAmount(amount: Double, unit: Convert.Unit, applicationViewModel: ApplicationViewModel): String {
//        return if (applicationViewModel.connectedWithMetamask()) ceil(amount).toInt().toString() else Convert.toWei(amount.toString(), unit).toBigInteger().toString()
        return Convert.toWei(amount.toString(), unit).toBigInteger().toString()
    }

    fun createApproveCurrencyMessage(spender: String, amount: Price): String {
        val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
            "approve",
            listOf(Address(spender), Uint256(amount.value.toBigInteger())), listOf())
        return FunctionEncoder.encode(function)
    }
    fun createCurrencyAllowanceMessage(spender: String, walletAddress: String): String {
        val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
            "allowance",
            listOf(Address(walletAddress), Address(spender)), listOf(object : TypeReference<Uint256>() {}))
        return FunctionEncoder.encode(function)
    }

    var web3jInstance: Web3j? = null
    suspend fun createWeb3j(finish: () -> Unit) {
        val service = WebSocketService(if (ApolloClient.debug) NODE_SEPOLIA else NODE, true)
        try {
            service.connect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        web3jInstance = Web3j.build(service)
        finish()
    }

    suspend fun getAllowance(currencyAddress: String, walletAddress: String, spender: String): Double {
        return try {
            val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
                "allowance",
                listOf(Address(walletAddress), Address(spender)), listOf(object : TypeReference<Uint256>() {}))

            val encodedFunction = FunctionEncoder.encode(function)
            val response: EthCall? = web3jInstance?.ethCall(
                Transaction.createEthCallTransaction(walletAddress, currencyAddress, encodedFunction),
                DefaultBlockParameterName.LATEST
            )?.sendAsync()?.get()
            Timber.tag("hercule").i("getAllowance result:${response?.value}")
            Convert.fromWei(response?.value?.substring(2)?.toBigInteger(16).toString(), BALANCE_CONVERT_UNIT).toDouble()
        } catch (e: Exception) {
            e.printStackTrace()
            0.0
        }
    }

    suspend fun balanceOf(currencyAddress: String, walletAddress: String): Double {
        return try {
            val function: org.web3j.abi.datatypes.Function = org.web3j.abi.datatypes.Function(
                "balanceOf",
                listOf(Address(walletAddress)), listOf(object : TypeReference<Uint256>() {}))

            val encodedFunction = FunctionEncoder.encode(function)
            val response: EthCall? = web3jInstance?.ethCall(
                Transaction.createEthCallTransaction(walletAddress, currencyAddress, encodedFunction),
                DefaultBlockParameterName.LATEST
            )?.sendAsync()?.get()
            Timber.tag("hercule").i("balanceOf result:$response")
            Convert.fromWei(response?.value?.substring(2)?.toBigInteger(16).toString(), BALANCE_CONVERT_UNIT).toDouble()
        } catch (e: Exception) {
            e.printStackTrace()
            0.0
        }
    }
    suspend fun getEthBalance(walletAddress: String): Double {
        return try {
            val balanceResponse = web3jInstance?.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST)?.send()
            return if (balanceResponse?.hasError() == true) {
                Timber.tag("hercule").i("getEthBalance error:${balanceResponse.error.message}")
                0.0
            } else {
                Timber.tag("hercule").i("getEthBalance result:${balanceResponse?.balance}")
                Convert.fromWei(balanceResponse?.balance.toString(), Convert.Unit.ETHER).toDouble()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            0.0
        }
    }
}

enum class Chains(
    val chainName: String,
    val chainNamespace: String,
    val chainReference: String,
    val methods: List<String>,
    val events: List<String>,
    val order: Int,
    val chainId: String = "$chainNamespace:$chainReference"
) {

    ETHEREUM_MAIN(
        chainName = "Ethereum",
        chainNamespace = Info.Eth.chain,
        chainReference = "1",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 1
    ),

    POLYGON_MATIC(
        chainName = "Polygon",
        chainNamespace = Info.Eth.chain,
        chainReference = "137",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 2
    ),

    ETHEREUM_KOVAN(
        chainName = "Ethereum Kovan",
        chainNamespace = Info.Eth.chain,
        chainReference = "42",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 3
    ),

    OPTIMISM_KOVAN(
        chainName = "Optimism Kovan",
        chainNamespace = Info.Eth.chain,
        chainReference = "69",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 4
    ),

    POLYGON_MUMBAI(
        chainName = "Polygon Mumbai",
        chainNamespace = Info.Eth.chain,
        chainReference = "80001",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 5
    ),

    ARBITRUM_RINKBY(
        chainName = "Arbitrum Rinkeby",
        chainNamespace = Info.Eth.chain,
        chainReference = "421611",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 6
    ),

    CELO_ALFAJORES(
        chainName = "Celo Alfajores",
        chainNamespace = Info.Eth.chain,
        chainReference = "44787",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 7
    ),
    COSMOS(
        chainName = "Cosmos",
        chainNamespace = Info.Cosmos.chain,
        chainReference = "cosmoshub-4",
        methods = Info.Cosmos.defaultMethods,
        events = Info.Cosmos.defaultEvents,
        order = 7
    ),
    BNB(
        chainName = "BNB Smart Chain",
        chainNamespace = Info.Eth.chain,
        chainReference = "56",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 8
    ),
    OP_MAIN(
        chainName = "OP Mainnet",
        chainNamespace = Info.Eth.chain,
        chainReference = "10",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 9
    ),
    OP_BNB(
        chainName = "opBNB",
        chainNamespace = Info.Eth.chain,
        chainReference = "204",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 10
    ),
    BASE(
        chainName = "Base",
        chainNamespace = Info.Eth.chain,
        chainReference = "8453",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 11
    ),
    ARBITRUM_ONE(
        chainName = "Arbitrum One",
        chainNamespace = Info.Eth.chain,
        chainReference = "42161",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 12
    ),
    LINEA(
        chainName = "Linea",
        chainNamespace = Info.Eth.chain,
        chainReference = "59144",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 13
    ),
    SCROLL(
        chainName = "Scroll",
        chainNamespace = Info.Eth.chain,
        chainReference = "534352",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 14
    ),
    OP_GOERLI(
        chainName = "Optimism Goerli",
        chainNamespace = Info.Eth.chain,
        chainReference = "420",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 15
    ),
    OP_SEPOLIA(
        chainName = "Optimism Sepolia",
        chainNamespace = Info.Eth.chain,
        chainReference = "11155420",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 16
    ),
    Gnosis(
        chainName = "Gnosis",
        chainNamespace = Info.Eth.chain,
        chainReference = "100",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 17
    ),
    SBC(
        chainName = "Smart Bitcoin Cash",
        chainNamespace = Info.Eth.chain,
        chainReference = "10000",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 18
    ),
    Conflux(
        chainName = "Conflux eSpace",
        chainNamespace = Info.Eth.chain,
        chainReference = "1030",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 19
    ),
    Metis(
        chainName = "Metis",
        chainNamespace = Info.Eth.chain,
        chainReference = "1088",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 20
    ),
    OpBNB_Test(
        chainName = "OpBNB Testnet",
        chainNamespace = Info.Eth.chain,
        chainReference = "5611",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 21
    ),
    Base_Sepolia(
        chainName = "Base Sepolia",
        chainNamespace = Info.Eth.chain,
        chainReference = "84532",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 22
    ),
    Arbitrum_Sepolia(
        chainName = "Arbitrum Sepolia",
        chainNamespace = Info.Eth.chain,
        chainReference = "421614",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 23
    ),
    Cyber(
        chainName = "Cyber",
        chainNamespace = Info.Eth.chain,
        chainReference = "7560",
        methods = Info.Eth.defaultMethods,
        events = Info.Eth.defaultEvents,
        order = 24
    ),
    ;

    sealed class Info {
        abstract val chain: String
        abstract val defaultEvents: List<String>
        abstract val defaultMethods: List<String>

        val DEFAULT_METHODS = listOf(
            "eth_sendTransaction",
            "personal_sign",
            "eth_sign",
            "eth_signTypedData"
        )
        val METAMASK_METHODS = listOf(
            "eth_sendTransaction",
            "personal_sign",
            "eth_sign",
            "eth_signTypedData",
            "wallet_switchEthereumChain"
        )

        object Eth: Info() {
            override val chain = "eip155"
            override val defaultEvents: List<String> = listOf("chainChanged", "accountsChanged")
            override val defaultMethods: List<String> = DEFAULT_METHODS
        }

        object Cosmos: Info() {
            override val chain = "cosmos"
            override val defaultEvents: List<String> = listOf("chainChanged", "accountsChanged")
            override val defaultMethods: List<String> = listOf(
                "cosmos_signDirect",
                "cosmos_signAmino"
            )
        }
    }
}