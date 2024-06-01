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
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.SchoolmatesConnectionsQuery_ResponseAdapter
import com.cyberconnect.link3.fragment.PerProfileWithOrg
import com.cyberconnect.link3.selections.SchoolmatesConnectionsQuerySelections
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public class SchoolmatesConnectionsQuery() : Query<SchoolmatesConnectionsQuery.Data> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> =
      SchoolmatesConnectionsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Query.type
  )
  .selections(selections = SchoolmatesConnectionsQuerySelections.__root)
  .build()

  @ApolloAdaptableWith(SchoolmatesConnectionsQuery_ResponseAdapter.Data::class)
  public data class Data(
    public val me: Me,
  ) : Query.Data

  public data class Me(
    public val `data`: Data1?,
  )

  public data class Data1(
    public val schoolmatesProfiles: List<SchoolmatesProfile>,
  )

  public data class SchoolmatesProfile(
    public val __typename: String,
    /**
     * Synthetic field for 'PerProfileWithOrg'
     */
    public val perProfileWithOrg: PerProfileWithOrg,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "83f57c1674c49579bef98cf20ed251781fe398ac7cee6106867226c95ed73b5e"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query schoolmatesConnections {
     *   me {
     *     data {
     *       schoolmatesProfiles {
     *         __typename
     *         ...PerProfileWithOrg
     *       }
     *     }
     *   }
     * }
     *
     * fragment ConnectionPersonalProfile on PerProfile {
     *   id
     *   handle
     *   owner {
     *     id
     *     price {
     *       price {
     *         value
     *         decimal
     *       }
     *     }
     *     lightInfo {
     *       attestation {
     *         uid
     *       }
     *     }
     *   }
     *   headline {
     *     displayName
     *     title
     *   }
     *   displayName {
     *     displayName
     *     type
     *   }
     *   profilePicture {
     *     picture
     *   }
     *   connectStatus
     *   connectionDegree
     *   reputation {
     *     total
     *   }
     *   isVerified
     *   mutualConnections {
     *     list {
     *       __typename
     *       handle
     *       id
     *       ... on PerProfile {
     *         profilePicture {
     *           picture
     *         }
     *         displayName {
     *           displayName
     *         }
     *       }
     *     }
     *   }
     * }
     *
     * fragment PerProfileWithOrg on PerProfileWithOrg {
     *   orgList {
     *     avatar
     *     name
     *   }
     *   profile {
     *     __typename
     *     ...ConnectionPersonalProfile
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query schoolmatesConnections { me { data { schoolmatesProfiles { __typename ...PerProfileWithOrg } } } }  fragment ConnectionPersonalProfile on PerProfile { id handle owner { id price { price { value decimal } } lightInfo { attestation { uid } } } headline { displayName title } displayName { displayName type } profilePicture { picture } connectStatus connectionDegree reputation { total } isVerified mutualConnections { list { __typename handle id ... on PerProfile { profilePicture { picture } displayName { displayName } } } } }  fragment PerProfileWithOrg on PerProfileWithOrg { orgList { avatar name } profile { __typename ...ConnectionPersonalProfile } }"

    public const val OPERATION_NAME: String = "schoolmatesConnections"
  }
}
