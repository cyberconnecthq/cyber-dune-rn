//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.AnyAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.type.TwitterInput
import kotlin.IllegalStateException
import kotlin.Unit

public object TwitterInput_InputAdapter : Adapter<TwitterInput> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      TwitterInput = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: TwitterInput,
  ): Unit {
    writer.name("twitterId")
    StringAdapter.toJson(writer, customScalarAdapters, value.twitterId)
    writer.name("twitterHandle")
    StringAdapter.toJson(writer, customScalarAdapters, value.twitterHandle)
    writer.name("displayName")
    StringAdapter.toJson(writer, customScalarAdapters, value.displayName)
    writer.name("avatar")
    AnyAdapter.toJson(writer, customScalarAdapters, value.avatar)
    writer.name("title")
    StringAdapter.toJson(writer, customScalarAdapters, value.title)
    writer.name("description")
    StringAdapter.toJson(writer, customScalarAdapters, value.description)
    if (value.followersCount is Optional.Present) {
      writer.name("followersCount")
      NullableIntAdapter.present().toJson(writer, customScalarAdapters, value.followersCount)
    }
    if (value.headlineType is Optional.Present) {
      writer.name("headlineType")
      HeadlineType_ResponseAdapter.nullable().present().toJson(writer, customScalarAdapters,
          value.headlineType)
    }
  }
}
