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
import com.cyberconnect.link3.type.TrendingEventsRequest_EventOrder
import kotlin.Unit

public object TrendingEventsRequest_EventOrder_ResponseAdapter :
    Adapter<TrendingEventsRequest_EventOrder> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      TrendingEventsRequest_EventOrder {
    val rawValue = reader.nextString()!!
    return TrendingEventsRequest_EventOrder.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: TrendingEventsRequest_EventOrder,
  ): Unit {
    writer.value(value.rawValue)
  }
}