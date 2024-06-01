//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GalaxyCred
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.Poap
import com.cyberconnect.link3.type.Url
import kotlin.collections.List

public object CredentialBlockSelections {
  private val __galaxyCreds: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __poaps: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "imageUrl",
          type = Url.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "galaxyCreds",
          type = GalaxyCred.type.notNull().list()
        ).selections(__galaxyCreds)
        .build(),
        CompiledField.Builder(
          name = "poaps",
          type = Poap.type.notNull().list()
        ).selections(__poaps)
        .build()
      )
}
