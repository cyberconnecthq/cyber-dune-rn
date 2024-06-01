//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableIntAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.GetPostCommentQuery
import kotlin.IllegalStateException
import kotlin.Unit

public object GetPostCommentQuery_VariablesAdapter : Adapter<GetPostCommentQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GetPostCommentQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GetPostCommentQuery,
  ): Unit {
    writer.name("postId")
    StringAdapter.toJson(writer, customScalarAdapters, value.postId)
    if (value.first is Optional.Present) {
      writer.name("first")
      NullableIntAdapter.present().toJson(writer, customScalarAdapters, value.first)
    }
    if (value.after is Optional.Present) {
      writer.name("after")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.after)
    }
  }
}
