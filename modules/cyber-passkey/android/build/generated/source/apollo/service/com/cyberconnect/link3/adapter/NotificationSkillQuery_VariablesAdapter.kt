//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.NotificationSkillQuery
import kotlin.IllegalStateException
import kotlin.Unit

public object NotificationSkillQuery_VariablesAdapter : Adapter<NotificationSkillQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      NotificationSkillQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: NotificationSkillQuery,
  ): Unit {
    if (value.after is Optional.Present) {
      writer.name("after")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.after)
    }
  }
}