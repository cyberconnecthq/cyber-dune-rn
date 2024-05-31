export type TxData = {
    amount_staked_bnb: number;
    amount_staked_eth: number | null;
    amount_staked_op: number;
    amount_staked_total: number;
    block_hour: string;
    cumulative_amount_staked_bnb: number;
    cumulative_amount_staked_eth: number;
    cumulative_amount_staked_op: number;
    cumulative_amount_staked_total: number;
    cumulative_num_stake_all: number;
    cumulative_num_stake_bnb: number;
    cumulative_num_stake_ethereum: number;
    cumulative_num_stake_optimism: number;
    num_stake_all: number;
    num_stake_bnb: number;
    num_stake_ethereum: number;
    num_stake_optimism: number;
  };
  
export type TxDataResponse = {
  rows: TxData[];
};
  
export type TxDataResponseAll = {
    result: TxDataResponse;
 };