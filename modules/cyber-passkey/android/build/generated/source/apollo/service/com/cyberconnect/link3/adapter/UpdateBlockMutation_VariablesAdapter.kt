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
import com.cyberconnect.link3.UpdateBlockMutation
import com.cyberconnect.link3.type.adapter.UpdateBlockInput_InputAdapter
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdateBlockMutation_VariablesAdapter : Adapter<UpdateBlockMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdateBlockMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdateBlockMutation,
  ): Unit {
    writer.name("id")
    StringAdapter.toJson(writer, customScalarAdapters, value.id)
    writer.name("input")
    UpdateBlockInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}