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
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.type.SubmitEasWhitelistInput
import kotlin.IllegalStateException
import kotlin.Unit

public object SubmitEasWhitelistInput_InputAdapter : Adapter<SubmitEasWhitelistInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      SubmitEasWhitelistInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: SubmitEasWhitelistInput,
  ): Unit {
    writer.name("headline")
    TwitterInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.headline)
    writer.name("email")
    StringAdapter.toJson(writer, customScalarAdapters, value.email)
    writer.name("token")
    StringAdapter.toJson(writer, customScalarAdapters, value.token)
  }
}