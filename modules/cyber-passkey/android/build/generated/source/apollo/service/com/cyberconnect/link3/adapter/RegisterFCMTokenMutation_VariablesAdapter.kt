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
import com.cyberconnect.link3.RegisterFCMTokenMutation
import com.cyberconnect.link3.type.adapter.RegisterFCMTokenRequest_InputAdapter
import kotlin.IllegalStateException
import kotlin.Unit

public object RegisterFCMTokenMutation_VariablesAdapter : Adapter<RegisterFCMTokenMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      RegisterFCMTokenMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: RegisterFCMTokenMutation,
  ): Unit {
    writer.name("input")
    RegisterFCMTokenRequest_InputAdapter.obj().toJson(writer, customScalarAdapters, value.input)
  }
}
