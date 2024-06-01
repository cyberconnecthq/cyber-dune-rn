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
import com.cyberconnect.link3.adapter.GetTrendingPostsQuery_ResponseAdapter
import com.cyberconnect.link3.adapter.GetTrendingPostsQuery_VariablesAdapter
import com.cyberconnect.link3.fragment.ProfileInTrending
import com.cyberconnect.link3.selections.GetTrendingPostsQuerySelections
import com.cyberconnect.link3.type.TrendingPostsRequest_PostFilter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public data class GetTrendingPostsQuery(
  public val after: Optional<String?> = Optional.Absent,
  public val filter: Optional<TrendingPostsRequest_PostFilter?> = Optional.Absent,
  public val first: Optional<Int?> = Optional.Absent,
) : Query<GetTrendingPostsQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    GetTrendingPostsQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = GetTrendingPostsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = GetTrendingPostsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(GetTrendingPostsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val trendingPosts: TrendingPosts,
  ) : Query.Data

  public data class TrendingPosts(
    public val list: kotlin.collections.List<List>,
    public val pageInfo: PageInfo,
  )

  public data class List(
    public val id: String,
    public val title: String,
    public val cover: Any,
    public val description: String,
    public val viewCount: Int,
    public val publishedAt: Any,
    public val likeCount: Int,
    public val readTime: Int,
    public val essence: Essence?,
    public val likedStatus: LikedStatus,
    public val profile: Profile,
  )

  public data class Essence(
    public val totalCollected: Int,
    public val totalSupply: Int,
  )

  public data class LikedStatus(
    public val liked: Boolean,
  )

  public data class Profile(
    public val __typename: String,
    /**
     * Synthetic field for 'ProfileInTrending'
     */
    public val profileInTrending: ProfileInTrending,
  )

  public data class PageInfo(
    public val startCursor: String,
    public val endCursor: String,
    public val hasNextPage: Boolean,
    public val hasPreviousPage: Boolean,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "47aee7028385f06cc22516483070fe722e8c3c7fef0bab93f2ab6994447d5139"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query getTrendingPosts($after: String, $filter: TrendingPostsRequest_PostFilter, $first: Int
     * = 20 ) {
     *   trendingPosts(after: $after, filter: $filter, first: $first) {
     *     list {
     *       id
     *       title
     *       cover
     *       description
     *       viewCount
     *       publishedAt
     *       likeCount
     *       readTime
     *       essence {
     *         totalCollected
     *         totalSupply
     *       }
     *       likedStatus {
     *         liked
     *       }
     *       profile {
     *         __typename
     *         ...ProfileInTrending
     *       }
     *     }
     *     pageInfo {
     *       startCursor
     *       endCursor
     *       hasNextPage
     *       hasPreviousPage
     *     }
     *   }
     * }
     *
     * fragment UnionIsFollowing on Profile {
     *   __typename
     *   ... on OrgProfile {
     *     isFollowing
     *   }
     *   ... on PerProfile {
     *     isFollowing
     *   }
     * }
     *
     * fragment UnionDisplayName on Profile {
     *   __typename
     *   ... on OrgProfile {
     *     displayName
     *   }
     *   ... on PerProfile {
     *     personalDisplayName: displayName {
     *       displayName
     *     }
     *   }
     * }
     *
     * fragment UnionProfilePicture on Profile {
     *   __typename
     *   ... on OrgProfile {
     *     profilePicture
     *   }
     *   ... on PerProfile {
     *     personalProfilePicture: profilePicture {
     *       picture
     *     }
     *   }
     * }
     *
     * fragment UnionBaseProfile on Profile {
     *   __typename
     *   type
     *   handle
     *   ...UnionIsFollowing
     *   ...UnionDisplayName
     *   ...UnionProfilePicture
     * }
     *
     * fragment ProfileInTrending on Profile {
     *   __typename
     *   ...UnionBaseProfile
     *   ... on PerProfile {
     *     isFollowing
     *   }
     *   ... on OrgProfile {
     *     isFollowing
     *     organization {
     *       verification
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query getTrendingPosts(${'$'}after: String, ${'$'}filter: TrendingPostsRequest_PostFilter, ${'$'}first: Int = 20 ) { trendingPosts(after: ${'$'}after, filter: ${'$'}filter, first: ${'$'}first) { list { id title cover description viewCount publishedAt likeCount readTime essence { totalCollected totalSupply } likedStatus { liked } profile { __typename ...ProfileInTrending } } pageInfo { startCursor endCursor hasNextPage hasPreviousPage } } }  fragment UnionIsFollowing on Profile { __typename ... on OrgProfile { isFollowing } ... on PerProfile { isFollowing } }  fragment UnionDisplayName on Profile { __typename ... on OrgProfile { displayName } ... on PerProfile { personalDisplayName: displayName { displayName } } }  fragment UnionProfilePicture on Profile { __typename ... on OrgProfile { profilePicture } ... on PerProfile { personalProfilePicture: profilePicture { picture } } }  fragment UnionBaseProfile on Profile { __typename type handle ...UnionIsFollowing ...UnionDisplayName ...UnionProfilePicture }  fragment ProfileInTrending on Profile { __typename ...UnionBaseProfile ... on PerProfile { isFollowing } ... on OrgProfile { isFollowing organization { verification } } }"

    public const val OPERATION_NAME: String = "getTrendingPosts"
  }
}
