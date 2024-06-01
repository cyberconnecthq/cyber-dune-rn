//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.PointTaskPhase
import com.cyberconnect.link3.type.PointTaskStatus
import com.cyberconnect.link3.type.PointTaskType
import kotlin.collections.List

public object PointTaskSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "phase",
          type = PointTaskPhase.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "points",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "status",
          type = PointTaskStatus.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "taskType",
          type = PointTaskType.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "subtitle",
          type = GraphQLString.type.notNull()
        ).build()
      )
}