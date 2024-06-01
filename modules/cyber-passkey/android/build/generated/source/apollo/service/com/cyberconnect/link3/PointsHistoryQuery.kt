//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.PointsHistoryQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.PointsHistoryQuery_VariablesAdapter
import com.cyberconnect.link3.selections.PointsHistoryQuerySelections
import kotlin.String
import kotlin.Unit

public data class PointsHistoryQuery(
  public val after: Optional<String?> = Optional.Absent,
) : Query<PointsHistoryQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    PointsHistoryQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = PointsHistoryQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = PointsHistoryQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(PointsHistoryQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val pointHistory: PointHistory?,
  ) : Query.Data

  public data class PointHistory(
    public val pageInfo: PageInfo,
    public val list: kotlin.collections.List<List>?,
  )

  public data class PageInfo(
    public val __typename: String,
    /**
     * Synthetic field for 'PageInfo'
     */
    public val pageInfo: com.cyberconnect.link3.fragment.PageInfo,
  )

  public data class List(
    public val __typename: String,
    /**
     * Synthetic field for 'PointHistory'
     */
    public val pointHistory: com.cyberconnect.link3.fragment.PointHistory,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "d3f591d50596320aa6f66bd6e9640975bca6c6d8ab093a74cd6ca234add1ad01"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query pointsHistory($after: String) {
     *   pointHistory(first: 10, after: $after) {
     *     pageInfo {
     *       __typename
     *       ...PageInfo
     *     }
     *     list {
     *       __typename
     *       ...PointHistory
     *     }
     *   }
     * }
     *
     * fragment PageInfo on PageInfo {
     *   startCursor
     *   endCursor
     *   hasNextPage
     *   hasPreviousPage
     * }
     *
     * fragment PointTask on PointTask {
     *   id
     *   name
     *   phase
     *   points
     *   status
     *   taskType
     *   subtitle
     * }
     *
     * fragment PointHistory on PointHistory {
     *   task {
     *     __typename
     *     ...PointTask
     *   }
     *   createdAt
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query pointsHistory(${'$'}after: String) { pointHistory(first: 10, after: ${'$'}after) { pageInfo { __typename ...PageInfo } list { __typename ...PointHistory } } }  fragment PageInfo on PageInfo { startCursor endCursor hasNextPage hasPreviousPage }  fragment PointTask on PointTask { id name phase points status taskType subtitle }  fragment PointHistory on PointHistory { task { __typename ...PointTask } createdAt }"

    public const val OPERATION_NAME: String = "pointsHistory"
  }
}