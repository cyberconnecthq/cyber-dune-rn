//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.AckCollectV3W3STRequest
import kotlin.IllegalStateException
import kotlin.Unit

public object AckCollectV3W3STRequest_InputAdapter : Adapter<AckCollectV3W3STRequest> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      AckCollectV3W3STRequest = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: AckCollectV3W3STRequest,
  ): Unit {
    writer.name("collectId")
    StringAdapter.toJson(writer, customScalarAdapters, value.collectId)
    writer.name("txHash")
    StringAdapter.toJson(writer, customScalarAdapters, value.txHash)
  }
}
