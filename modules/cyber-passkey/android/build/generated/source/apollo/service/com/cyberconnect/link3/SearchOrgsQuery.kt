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
import com.cyberconnect.link3.adapter.SearchOrgsQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.SearchOrgsQuery_VariablesAdapter
import com.cyberconnect.link3.selections.SearchOrgsQuerySelections
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class SearchOrgsQuery(
  public val text: Optional<String?> = Optional.Absent,
  public val after: Optional<String?> = Optional.Absent,
  public val first: Optional<Int?> = Optional.Absent,
) : Query<SearchOrgsQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    SearchOrgsQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = SearchOrgsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = SearchOrgsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(SearchOrgsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val organizations: Organizations,
  ) : Query.Data

  public data class Organizations(
    public val pageInfo: PageInfo,
    public val list: kotlin.collections.List<List>,
    public val totalCount: Int,
  )

  public data class PageInfo(
    public val startCursor: String,
    public val endCursor: String,
    public val hasNextPage: Boolean,
    public val hasPreviousPage: Boolean,
  )

  public data class List(
    public val profile: Profile,
    public val followersCount: Int,
    public val lightInfo: LightInfo,
  )

  public data class Profile(
    public val id: String,
  )

  public data class LightInfo(
    public val profilePicture: String,
    public val displayName: String,
    public val isFollowing: Boolean,
    public val profileHandle: String,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "bde246072c0d01c773feaac2a3a57e9880540c4f7817ba3608330d4ce06aa14a"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query searchOrgs($text: String, $after: String, $first: Int = 50 ) {
     *   organizations(after: $after, displayNameFilter: $text, first: $first) {
     *     pageInfo {
     *       startCursor
     *       endCursor
     *       hasNextPage
     *       hasPreviousPage
     *     }
     *     list {
     *       profile {
     *         id
     *       }
     *       followersCount
     *       lightInfo {
     *         profilePicture
     *         displayName
     *         isFollowing
     *         profileHandle
     *       }
     *     }
     *     totalCount
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query searchOrgs(${'$'}text: String, ${'$'}after: String, ${'$'}first: Int = 50 ) { organizations(after: ${'$'}after, displayNameFilter: ${'$'}text, first: ${'$'}first) { pageInfo { startCursor endCursor hasNextPage hasPreviousPage } list { profile { id } followersCount lightInfo { profilePicture displayName isFollowing profileHandle } } totalCount } }"

    public const val OPERATION_NAME: String = "searchOrgs"
  }
}