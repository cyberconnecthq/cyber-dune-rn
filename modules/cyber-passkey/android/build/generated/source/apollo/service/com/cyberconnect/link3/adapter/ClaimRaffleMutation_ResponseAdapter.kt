//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.ClaimRaffleMutation
import com.cyberconnect.link3.type.AwardType
import com.cyberconnect.link3.type.ClaimRaffleAwardResponse_Status
import com.cyberconnect.link3.type.adapter.AwardType_ResponseAdapter
import com.cyberconnect.link3.type.adapter.ClaimRaffleAwardResponse_Status_ResponseAdapter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object ClaimRaffleMutation_ResponseAdapter {
  public object Data : Adapter<ClaimRaffleMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("claimRaffleAward")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ClaimRaffleMutation.Data {
      var _claimRaffleAward: ClaimRaffleMutation.ClaimRaffleAward? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _claimRaffleAward = ClaimRaffleAward.obj().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ClaimRaffleMutation.Data(
        claimRaffleAward = _claimRaffleAward!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ClaimRaffleMutation.Data,
    ): Unit {
      writer.name("claimRaffleAward")
      ClaimRaffleAward.obj().toJson(writer, customScalarAdapters, value.claimRaffleAward)
    }
  }

  public object ClaimRaffleAward : Adapter<ClaimRaffleMutation.ClaimRaffleAward> {
    public val RESPONSE_NAMES: List<String> = listOf("type", "status", "profileId", "currency",
        "signature", "amount", "deadline", "code")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        ClaimRaffleMutation.ClaimRaffleAward {
      var _type: AwardType? = null
      var _status: ClaimRaffleAwardResponse_Status? = null
      var _profileId: String? = null
      var _currency: String? = null
      var _signature: String? = null
      var _amount: String? = null
      var _deadline: String? = null
      var _code: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _type = AwardType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          1 -> _status = ClaimRaffleAwardResponse_Status_ResponseAdapter.fromJson(reader,
              customScalarAdapters)
          2 -> _profileId = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _currency = StringAdapter.fromJson(reader, customScalarAdapters)
          4 -> _signature = StringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _amount = StringAdapter.fromJson(reader, customScalarAdapters)
          6 -> _deadline = StringAdapter.fromJson(reader, customScalarAdapters)
          7 -> _code = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return ClaimRaffleMutation.ClaimRaffleAward(
        type = _type!!,
        status = _status!!,
        profileId = _profileId!!,
        currency = _currency!!,
        signature = _signature!!,
        amount = _amount!!,
        deadline = _deadline!!,
        code = _code!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: ClaimRaffleMutation.ClaimRaffleAward,
    ): Unit {
      writer.name("type")
      AwardType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("status")
      ClaimRaffleAwardResponse_Status_ResponseAdapter.toJson(writer, customScalarAdapters,
          value.status)

      writer.name("profileId")
      StringAdapter.toJson(writer, customScalarAdapters, value.profileId)

      writer.name("currency")
      StringAdapter.toJson(writer, customScalarAdapters, value.currency)

      writer.name("signature")
      StringAdapter.toJson(writer, customScalarAdapters, value.signature)

      writer.name("amount")
      StringAdapter.toJson(writer, customScalarAdapters, value.amount)

      writer.name("deadline")
      StringAdapter.toJson(writer, customScalarAdapters, value.deadline)

      writer.name("code")
      StringAdapter.toJson(writer, customScalarAdapters, value.code)
    }
  }
}
