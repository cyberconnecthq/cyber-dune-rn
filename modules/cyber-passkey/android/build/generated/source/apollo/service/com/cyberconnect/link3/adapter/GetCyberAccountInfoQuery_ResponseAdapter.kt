//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.GetCyberAccountInfoQuery
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object GetCyberAccountInfoQuery_ResponseAdapter {
  public object Data : Adapter<GetCyberAccountInfoQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("me")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.Data {
      var _me: GetCyberAccountInfoQuery.Me? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _me = Me.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.Data(
        me = _me!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.Data,
    ): Unit {
      writer.name("me")
      Me.obj().toJson(writer, customScalarAdapters, value.me)
    }
  }

  public object Me : Adapter<GetCyberAccountInfoQuery.Me> {
    public val RESPONSE_NAMES: List<String> = listOf("data")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.Me {
      var _data: GetCyberAccountInfoQuery.Data1? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _data = Data1.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.Me(
        `data` = _data
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.Me,
    ): Unit {
      writer.name("data")
      Data1.obj().nullable().toJson(writer, customScalarAdapters, value.`data`)
    }
  }

  public object Data1 : Adapter<GetCyberAccountInfoQuery.Data1> {
    public val RESPONSE_NAMES: List<String> = listOf("v3Info", "totalEarned", "dmCreditAccount",
        "pointAccount")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.Data1 {
      var _v3Info: GetCyberAccountInfoQuery.V3Info? = null
      var _totalEarned: GetCyberAccountInfoQuery.TotalEarned? = null
      var _dmCreditAccount: GetCyberAccountInfoQuery.DmCreditAccount? = null
      var _pointAccount: GetCyberAccountInfoQuery.PointAccount? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _v3Info = V3Info.obj().nullable().fromJson(reader, customScalarAdapters)
          1 -> _totalEarned = TotalEarned.obj(true).fromJson(reader, customScalarAdapters)
          2 -> _dmCreditAccount = DmCreditAccount.obj().fromJson(reader, customScalarAdapters)
          3 -> _pointAccount = PointAccount.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.Data1(
        v3Info = _v3Info,
        totalEarned = _totalEarned!!,
        dmCreditAccount = _dmCreditAccount!!,
        pointAccount = _pointAccount!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.Data1,
    ): Unit {
      writer.name("v3Info")
      V3Info.obj().nullable().toJson(writer, customScalarAdapters, value.v3Info)

      writer.name("totalEarned")
      TotalEarned.obj(true).toJson(writer, customScalarAdapters, value.totalEarned)

      writer.name("dmCreditAccount")
      DmCreditAccount.obj().toJson(writer, customScalarAdapters, value.dmCreditAccount)

      writer.name("pointAccount")
      PointAccount.obj().toJson(writer, customScalarAdapters, value.pointAccount)
    }
  }

  public object V3Info : Adapter<GetCyberAccountInfoQuery.V3Info> {
    public val RESPONSE_NAMES: List<String> = listOf("cyberAccount", "credits")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.V3Info {
      var _cyberAccount: String? = null
      var _credits: List<GetCyberAccountInfoQuery.Credit>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _cyberAccount = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _credits = Credit.obj().list().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.V3Info(
        cyberAccount = _cyberAccount!!,
        credits = _credits!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.V3Info,
    ): Unit {
      writer.name("cyberAccount")
      StringAdapter.toJson(writer, customScalarAdapters, value.cyberAccount)

      writer.name("credits")
      Credit.obj().list().toJson(writer, customScalarAdapters, value.credits)
    }
  }

  public object Credit : Adapter<GetCyberAccountInfoQuery.Credit> {
    public val RESPONSE_NAMES: List<String> = listOf("decimals", "balance", "pending", "locked")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.Credit {
      var _decimals: Int? = null
      var _balance: String? = null
      var _pending: String? = null
      var _locked: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _decimals = IntAdapter.fromJson(reader, customScalarAdapters)
          1 -> _balance = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _pending = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _locked = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.Credit(
        decimals = _decimals!!,
        balance = _balance!!,
        pending = _pending!!,
        locked = _locked!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.Credit,
    ): Unit {
      writer.name("decimals")
      IntAdapter.toJson(writer, customScalarAdapters, value.decimals)

      writer.name("balance")
      StringAdapter.toJson(writer, customScalarAdapters, value.balance)

      writer.name("pending")
      StringAdapter.toJson(writer, customScalarAdapters, value.pending)

      writer.name("locked")
      StringAdapter.toJson(writer, customScalarAdapters, value.locked)
    }
  }

  public object TotalEarned : Adapter<GetCyberAccountInfoQuery.TotalEarned> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.TotalEarned {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _price = com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.fromJson(reader,
          customScalarAdapters)

      return GetCyberAccountInfoQuery.TotalEarned(
        __typename = __typename!!,
        price = _price
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.TotalEarned,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.toJson(writer,
          customScalarAdapters, value.price)
    }
  }

  public object DmCreditAccount : Adapter<GetCyberAccountInfoQuery.DmCreditAccount> {
    public val RESPONSE_NAMES: List<String> = listOf("balance", "nonWithdrawableBalance",
        "withdrawableBalance")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.DmCreditAccount {
      var _balance: GetCyberAccountInfoQuery.Balance? = null
      var _nonWithdrawableBalance: GetCyberAccountInfoQuery.NonWithdrawableBalance? = null
      var _withdrawableBalance: GetCyberAccountInfoQuery.WithdrawableBalance? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _balance = Balance.obj(true).fromJson(reader, customScalarAdapters)
          1 -> _nonWithdrawableBalance = NonWithdrawableBalance.obj(true).fromJson(reader,
              customScalarAdapters)
          2 -> _withdrawableBalance = WithdrawableBalance.obj(true).fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.DmCreditAccount(
        balance = _balance!!,
        nonWithdrawableBalance = _nonWithdrawableBalance!!,
        withdrawableBalance = _withdrawableBalance!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.DmCreditAccount,
    ): Unit {
      writer.name("balance")
      Balance.obj(true).toJson(writer, customScalarAdapters, value.balance)

      writer.name("nonWithdrawableBalance")
      NonWithdrawableBalance.obj(true).toJson(writer, customScalarAdapters,
          value.nonWithdrawableBalance)

      writer.name("withdrawableBalance")
      WithdrawableBalance.obj(true).toJson(writer, customScalarAdapters, value.withdrawableBalance)
    }
  }

  public object Balance : Adapter<GetCyberAccountInfoQuery.Balance> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.Balance {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _price = com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.fromJson(reader,
          customScalarAdapters)

      return GetCyberAccountInfoQuery.Balance(
        __typename = __typename!!,
        price = _price
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.Balance,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.toJson(writer,
          customScalarAdapters, value.price)
    }
  }

  public object NonWithdrawableBalance : Adapter<GetCyberAccountInfoQuery.NonWithdrawableBalance> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.NonWithdrawableBalance {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _price = com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.fromJson(reader,
          customScalarAdapters)

      return GetCyberAccountInfoQuery.NonWithdrawableBalance(
        __typename = __typename!!,
        price = _price
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.NonWithdrawableBalance,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.toJson(writer,
          customScalarAdapters, value.price)
    }
  }

  public object WithdrawableBalance : Adapter<GetCyberAccountInfoQuery.WithdrawableBalance> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.WithdrawableBalance {
      var __typename: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      reader.rewind()
      val _price = com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.fromJson(reader,
          customScalarAdapters)

      return GetCyberAccountInfoQuery.WithdrawableBalance(
        __typename = __typename!!,
        price = _price
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.WithdrawableBalance,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      com.cyberconnect.link3.fragment.PriceImpl_ResponseAdapter.Price.toJson(writer,
          customScalarAdapters, value.price)
    }
  }

  public object PointAccount : Adapter<GetCyberAccountInfoQuery.PointAccount> {
    public val RESPONSE_NAMES: List<String> = listOf("totalPoints")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetCyberAccountInfoQuery.PointAccount {
      var _totalPoints: Int? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _totalPoints = IntAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetCyberAccountInfoQuery.PointAccount(
        totalPoints = _totalPoints!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetCyberAccountInfoQuery.PointAccount,
    ): Unit {
      writer.name("totalPoints")
      IntAdapter.toJson(writer, customScalarAdapters, value.totalPoints)
    }
  }
}