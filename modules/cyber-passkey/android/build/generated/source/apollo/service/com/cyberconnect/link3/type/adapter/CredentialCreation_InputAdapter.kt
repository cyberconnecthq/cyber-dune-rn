//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.apollographql.apollo3.api.present
import com.cyberconnect.link3.type.CredentialCreation
import kotlin.IllegalStateException
import kotlin.Unit

public object CredentialCreation_InputAdapter : Adapter<CredentialCreation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      CredentialCreation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: CredentialCreation,
  ): Unit {
    if (value.galaxyCreds is Optional.Present) {
      writer.name("galaxyCreds")
      GalaxyCredInput_InputAdapter.obj().list().nullable().present().toJson(writer,
          customScalarAdapters, value.galaxyCreds)
    }
    if (value.poaps is Optional.Present) {
      writer.name("poaps")
      PoapInput_InputAdapter.obj().list().nullable().present().toJson(writer, customScalarAdapters,
          value.poaps)
    }
  }
}