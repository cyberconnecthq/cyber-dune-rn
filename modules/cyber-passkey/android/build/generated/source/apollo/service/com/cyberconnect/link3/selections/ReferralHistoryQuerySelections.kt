//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.fragment.selections.PageInfoSelections
import com.cyberconnect.link3.fragment.selections.ReferralHistorySelections
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.InviteHistory
import com.cyberconnect.link3.type.InviteHistoryPage
import com.cyberconnect.link3.type.PageInfo
import kotlin.collections.List

public object ReferralHistoryQuerySelections {
  private val __pageInfo: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "PageInfo",
          possibleTypes = listOf("PageInfo")
        ).selections(PageInfoSelections.__root)
        .build()
      )

  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "InviteHistory",
          possibleTypes = listOf("InviteHistory")
        ).selections(ReferralHistorySelections.__root)
        .build()
      )

  private val __inviteHistory: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build(),
        CompiledField.Builder(
          name = "list",
          type = InviteHistory.type.notNull().list()
        ).selections(__list)
        .build(),
        CompiledField.Builder(
          name = "invitedCount",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "verifiedCount",
          type = GraphQLInt.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "inviteHistory",
          type = InviteHistoryPage.type
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("first", 20).build()
        ))
        .selections(__inviteHistory)
        .build()
      )
}