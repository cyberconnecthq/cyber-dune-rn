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
import com.cyberconnect.link3.adapter.GetMyWestQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.GetMyWestQuery_VariablesAdapter
import com.cyberconnect.link3.selections.GetMyWestQuerySelections
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class GetMyWestQuery(
  public val first: Optional<Int?> = Optional.Absent,
  public val after: Optional<String?> = Optional.Absent,
) : Query<GetMyWestQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetMyWestQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetMyWestQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = GetMyWestQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetMyWestQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val me: Me,
  ) : Query.Data

  public data class Me(
    public val `data`: Data1?,
  )

  public data class Data1(
    public val myW3ST: MyW3ST?,
  )

  public data class MyW3ST(
    public val pageInfo: PageInfo,
    public val list: kotlin.collections.List<List>,
  )

  public data class PageInfo(
    public val __typename: String,
    /**
     * Synthetic field for 'PageInfo'
     */
    public val pageInfo: com.cyberconnect.link3.fragment.PageInfo,
  )

  public data class List(
    public val tokenUri: String,
    public val chainId: Int,
    public val version: Int,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "4440e9c9fec9e1689ea8b034658e5f1a022ab358774dc87dbb59ab4cd101449e"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query getMyWest($first: Int, $after: String) {
     *   me {
     *     data {
     *       myW3ST(first: $first, after: $after) {
     *         pageInfo {
     *           __typename
     *           ...PageInfo
     *         }
     *         list {
     *           tokenUri
     *           chainId
     *           version
     *         }
     *       }
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
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query getMyWest(${'$'}first: Int, ${'$'}after: String) { me { data { myW3ST(first: ${'$'}first, after: ${'$'}after) { pageInfo { __typename ...PageInfo } list { tokenUri chainId version } } } } }  fragment PageInfo on PageInfo { startCursor endCursor hasNextPage hasPreviousPage }"

    public const val OPERATION_NAME: String = "getMyWest"
  }
}
