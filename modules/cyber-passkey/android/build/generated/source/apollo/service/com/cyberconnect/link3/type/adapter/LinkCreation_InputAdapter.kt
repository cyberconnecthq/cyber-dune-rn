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
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.LinkCreation
import kotlin.IllegalStateException
import kotlin.Unit

public object LinkCreation_InputAdapter : Adapter<LinkCreation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      LinkCreation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: LinkCreation,
  ): Unit {
    writer.name("links")
    LinkInput_InputAdapter.obj().list().toJson(writer, customScalarAdapters, value.links)
  }
}
