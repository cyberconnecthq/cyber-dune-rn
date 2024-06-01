//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.cyberconnect.link3.type.ContactCreation
import kotlin.IllegalStateException
import kotlin.Unit

public object ContactCreation_InputAdapter : Adapter<ContactCreation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      ContactCreation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: ContactCreation,
  ): Unit {
    writer.name("enable")
    BooleanAdapter.toJson(writer, customScalarAdapters, value.enable)
    writer.name("hideEmail")
    BooleanAdapter.toJson(writer, customScalarAdapters, value.hideEmail)
    writer.name("hideTwitter")
    BooleanAdapter.toJson(writer, customScalarAdapters, value.hideTwitter)
    writer.name("hideLinkedin")
    BooleanAdapter.toJson(writer, customScalarAdapters, value.hideLinkedin)
    writer.name("hideGithub")
    BooleanAdapter.toJson(writer, customScalarAdapters, value.hideGithub)
  }
}
