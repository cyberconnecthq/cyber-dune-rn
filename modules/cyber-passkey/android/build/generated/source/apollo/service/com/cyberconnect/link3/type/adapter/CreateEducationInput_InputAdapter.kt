//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.type.CreateEducationInput
import kotlin.IllegalStateException
import kotlin.Unit

public object CreateEducationInput_InputAdapter : Adapter<CreateEducationInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      CreateEducationInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: CreateEducationInput,
  ): Unit {
    writer.name("profileId")
    StringAdapter.toJson(writer, customScalarAdapters, value.profileId)
    writer.name("title")
    StringAdapter.toJson(writer, customScalarAdapters, value.title)
    writer.name("orgName")
    StringAdapter.toJson(writer, customScalarAdapters, value.orgName)
    writer.name("orgTwitterId")
    StringAdapter.toJson(writer, customScalarAdapters, value.orgTwitterId)
    writer.name("orgTwitterHandle")
    StringAdapter.toJson(writer, customScalarAdapters, value.orgTwitterHandle)
    writer.name("orgAvatar")
    AnyAdapter.toJson(writer, customScalarAdapters, value.orgAvatar)
    writer.name("startDate")
    IntAdapter.toJson(writer, customScalarAdapters, value.startDate)
    if (value.endDate is Optional.Present) {
      writer.name("endDate")
      NullableIntAdapter.present().toJson(writer, customScalarAdapters, value.endDate)
    }
    writer.name("description")
    StringAdapter.toJson(writer, customScalarAdapters, value.description)
    if (value.degree is Optional.Present) {
      writer.name("degree")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.degree)
    }
    if (value.fieldOfStudy is Optional.Present) {
      writer.name("fieldOfStudy")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.fieldOfStudy)
    }
  }
}