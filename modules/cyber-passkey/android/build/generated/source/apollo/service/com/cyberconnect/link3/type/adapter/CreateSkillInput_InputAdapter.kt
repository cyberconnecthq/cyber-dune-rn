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
import com.cyberconnect.link3.type.CreateSkillInput
import kotlin.IllegalStateException
import kotlin.Unit

public object CreateSkillInput_InputAdapter : Adapter<CreateSkillInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      CreateSkillInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: CreateSkillInput,
  ): Unit {
    writer.name("profileId")
    StringAdapter.toJson(writer, customScalarAdapters, value.profileId)
    writer.name("name")
    StringAdapter.toJson(writer, customScalarAdapters, value.name)
  }
}
