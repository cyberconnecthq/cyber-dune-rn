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
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.SuperLink
import com.cyberconnect.link3.type.SuperLinkType
import com.cyberconnect.link3.type.Url
import kotlin.collections.List

public object SuperLinkBlockSelections {
  private val __superLinks: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "type",
          type = SuperLinkType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "title",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "link",
          type = Url.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "description",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "imageUrl",
          type = Url.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "superLinks",
          type = SuperLink.type.notNull().list().notNull()
        ).selections(__superLinks)
        .build()
      )
}