//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.NullableBooleanAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.type.TrendingEventsRequest_EventFilter
import kotlin.IllegalStateException
import kotlin.Unit

public object TrendingEventsRequest_EventFilter_InputAdapter :
    Adapter<TrendingEventsRequest_EventFilter> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      TrendingEventsRequest_EventFilter = throw
      IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: TrendingEventsRequest_EventFilter,
  ): Unit {
    if (value.languages is Optional.Present) {
      writer.name("languages")
      IntAdapter.list().nullable().present().toJson(writer, customScalarAdapters, value.languages)
    }
    if (value.tags is Optional.Present) {
      writer.name("tags")
      StringAdapter.list().nullable().present().toJson(writer, customScalarAdapters, value.tags)
    }
    if (value.enableEssence is Optional.Present) {
      writer.name("enableEssence")
      NullableBooleanAdapter.present().toJson(writer, customScalarAdapters, value.enableEssence)
    }
    if (value.enableRaffle is Optional.Present) {
      writer.name("enableRaffle")
      NullableBooleanAdapter.present().toJson(writer, customScalarAdapters, value.enableRaffle)
    }
    if (value.eventType is Optional.Present) {
      writer.name("eventType")
      EventType_ResponseAdapter.list().nullable().present().toJson(writer, customScalarAdapters,
          value.eventType)
    }
  }
}
