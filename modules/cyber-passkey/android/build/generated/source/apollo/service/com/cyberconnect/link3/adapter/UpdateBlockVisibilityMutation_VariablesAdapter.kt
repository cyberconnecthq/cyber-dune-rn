//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.UpdateBlockVisibilityMutation
import com.cyberconnect.link3.type.adapter.UpdateBlockVisibilityInput_InputAdapter
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdateBlockVisibilityMutation_VariablesAdapter :
    Adapter<UpdateBlockVisibilityMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdateBlockVisibilityMutation = throw
      IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdateBlockVisibilityMutation,
  ): Unit {
    writer.name("input")
    UpdateBlockVisibilityInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}
