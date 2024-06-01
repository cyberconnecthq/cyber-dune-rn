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
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.GetProposalsInSpaceQuery
import kotlin.IllegalStateException
import kotlin.Unit

public object GetProposalsInSpaceQuery_VariablesAdapter : Adapter<GetProposalsInSpaceQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      GetProposalsInSpaceQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: GetProposalsInSpaceQuery,
  ): Unit {
    if (value.first is Optional.Present) {
      writer.name("first")
      NullableIntAdapter.present().toJson(writer, customScalarAdapters, value.first)
    }
    if (value.spaceId is Optional.Present) {
      writer.name("spaceId")
      NullableStringAdapter.present().toJson(writer, customScalarAdapters, value.spaceId)
    }
  }
}
