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
import com.cyberconnect.link3.type.DeleteChatResponse_Status
import kotlin.Unit

public object DeleteChatResponse_Status_ResponseAdapter : Adapter<DeleteChatResponse_Status> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      DeleteChatResponse_Status {
    val rawValue = reader.nextString()!!
    return DeleteChatResponse_Status.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: DeleteChatResponse_Status,
  ): Unit {
    writer.value(value.rawValue)
  }
}
