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
import kotlin.collections.List

public object CodeAwardSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "code",
          type = GraphQLString.type.notNull().list().notNull()
        ).build(),
        CompiledField.Builder(
          name = "description",
          type = GraphQLString.type.notNull()
        ).build()
      )
}
