//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.RefreshChatPriceResponse_Status
import kotlin.Unit

public object RefreshChatPriceResponse_Status_ResponseAdapter :
    Adapter<RefreshChatPriceResponse_Status> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      RefreshChatPriceResponse_Status {
    val rawValue = reader.nextString()!!
    return RefreshChatPriceResponse_Status.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: RefreshChatPriceResponse_Status,
  ): Unit {
    writer.value(value.rawValue)
  }
}