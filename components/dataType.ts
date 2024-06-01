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

export type RestakeData = {
  amount_restaked_net_ezETH: number;
  amount_restaked_net_pufETH: number;
  amount_restaked_net_weETH: number;
  block_day: string; // or Date if you prefer to handle date objects
  cumulative_amount_restaked_ezETH: number;
  cumulative_amount_restaked_pufETH: number;
  cumulative_amount_restaked_weETH: number;
  cumulative_net_amount_restaked_total: number;
  cumulative_num_deposit_cnt: number;
  cumulative_num_restake_cnt: number;
  cumulative_num_withdraw_cnt: number;
  net_restaked_amount: number;
  num_deposit_cnt: number;
  num_restake_all_cnt: number;
  num_withdraw_cnt: number;
}
