//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.Proposal
import kotlin.collections.List

public object GetProposalsInSpaceQuerySelections {
  private val __proposals: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "title",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "body",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "start",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "end",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "state",
          type = GraphQLString.type
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "proposals",
          type = Proposal.type.list()
        ).arguments(listOf(
          CompiledArgument.Builder("first", CompiledVariable("first")).build(),
          CompiledArgument.Builder("where", mapOf(
            "space" to CompiledVariable("spaceId")
          )).build()
        ))
        .selections(__proposals)
        .build()
      )
}