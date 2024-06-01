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
import com.cyberconnect.link3.fragment.selections.SkillSelections
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.MeResponse
import com.cyberconnect.link3.type.Notification
import com.cyberconnect.link3.type.NotificationPage
import com.cyberconnect.link3.type.PageInfo
import com.cyberconnect.link3.type.User
import kotlin.collections.List

public object NotificationSkillQuerySelections {
  private val __list: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "SkillEndorsementNotification",
          possibleTypes = listOf("SkillEndorsementNotification")
        ).selections(SkillSelections.__root)
        .build()
      )

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

  private val __notifications: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "list",
          type = Notification.type.notNull().list().notNull()
        ).selections(__list)
        .build(),
        CompiledField.Builder(
          name = "pageInfo",
          type = PageInfo.type.notNull()
        ).selections(__pageInfo)
        .build()
      )

  private val __data: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "notifications",
          type = NotificationPage.type
        ).arguments(listOf(
          CompiledArgument.Builder("after", CompiledVariable("after")).build(),
          CompiledArgument.Builder("first", 50).build()
        ))
        .selections(__notifications)
        .build()
      )

  private val __me: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "data",
          type = User.type
        ).selections(__data)
        .build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "me",
          type = MeResponse.type.notNull()
        ).selections(__me)
        .build()
      )
}
