//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.WithdrawCreditInput
import kotlin.IllegalStateException
import kotlin.Unit

public object WithdrawCreditInput_InputAdapter : Adapter<WithdrawCreditInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      WithdrawCreditInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: WithdrawCreditInput,
  ): Unit {
    writer.name("chainId")
    IntAdapter.toJson(writer, customScalarAdapters, value.chainId)
    writer.name("address")
    StringAdapter.toJson(writer, customScalarAdapters, value.address)
    writer.name("value")
    TokenValueInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.`value`)
  }
}