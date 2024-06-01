import axios, { AxiosRequestConfig } from 'axios';
import { TxData, RestakeData } from './dataType'

export class NetworkingError extends Error {
  public readonly _tag = 'NetworkingError';
  public readonly status: number | undefined;

  constructor(message: string, status: number | undefined = undefined) {
    super(message);
    this.status = status;
  }
}

function createEndpointUrl(queryId: number, limit: number): string {
  return `https://api.dune.com/api/v1/query/${queryId}/results?limit=${limit}`;
}

const client = axios.create({
  headers: {
    'X-Dune-API-Key': 'l9QZejpnEMGqkNC7p1VXqgTqmXVjOX5B',
  },
});

export const axiosGet = async (url: string, config?: AxiosRequestConfig<unknown>) => {
  try {
    const response = await client.get(url, config);
    return response.data;
  } catch (error) {
    console.log('error fetch', error);
    throw new Error('network error');
  }
};

export const axiosGetTxNumber = async (queryId: number = 3502728, limit: number = 5): Promise<TxData[]> => {
  const endpointUrl = createEndpointUrl(queryId, limit);
  const res = await axiosGet(endpointUrl);
  return res.result.rows;
};

export const axiosGetRtxNumber = async (queryId: number = 3607806, limit: number = 1): Promise<RestakeData[]> => {
  const endpointUrl = createEndpointUrl(queryId, limit);
  const res = await axiosGet(endpointUrl);
  return res.result.rows;
};