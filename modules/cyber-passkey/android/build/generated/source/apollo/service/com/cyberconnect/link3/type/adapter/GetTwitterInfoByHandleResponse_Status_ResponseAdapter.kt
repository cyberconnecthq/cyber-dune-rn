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
import com.cyberconnect.link3.type.GetTwitterInfoByHandleResponse_Status
import kotlin.Unit

public object GetTwitterInfoByHandleResponse_Status_ResponseAdapter :
    Adapter<GetTwitterInfoByHandleResponse_Status> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GetTwitterInfoByHandleResponse_Status {
    val rawValue = reader.nextString()!!
    return GetTwitterInfoByHandleResponse_Status.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GetTwitterInfoByHandleResponse_Status,
  ): Unit {
    writer.value(value.rawValue)
  }
}
