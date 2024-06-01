import axios, { AxiosRequestConfig } from 'axios';
import { TxData } from './dataType'

export class NetworkingError extends Error {
  public readonly _tag = 'NetworkingError';
  public readonly status: number | undefined;

  constructor(message: string, status: number | undefined = undefined) {
    super(message);
    this.status = status;
  }
}

function createEndpointUrl(queryId: number = 3502728, limit: number = 5): string {
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
    console.log('fetch res', response);
    return response.data;
  } catch (error) {
    console.log('error fetch', error);
    throw new Error('network error');
  }
};

export const axiosGetTxNumber = async (queryId?: number, limit?: number): Promise<TxData[]> => {
  const endpointUrl = createEndpointUrl(queryId, limit);
  const res = await axiosGet(endpointUrl);
  return res.result.rows;
};
