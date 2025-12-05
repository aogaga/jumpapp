export class Rateresponse {
  base_code: string;
  documentation: string;
  provider: string;
  rates: Record<string, number>;
  result: string;
  terms_of_use: string;
  time_eol_unix: number;
  time_last_update_unix: number;
  time_last_update_utc: string;
  time_next_update_unix: number;
  time_next_update_utc: string;

  constructor(data: any) {
    this.base_code = data.base_code;
    this.documentation = data.documentation;
    this.provider = data.provider;
    this.rates = data.rates;
    this.result = data.result;
    this.terms_of_use = data.terms_of_use;
    this.time_eol_unix = data.time_eol_unix;
    this.time_last_update_unix = data.time_last_update_unix;
    this.time_last_update_utc = data.time_last_update_utc;
    this.time_next_update_unix = data.time_next_update_unix;
    this.time_next_update_utc = data.time_next_update_utc;
  }

  // Optional helper methods
  getRate(currency: string): number | undefined {
    return this.rates[currency];
  }

  convert(amount: number, toCurrency: string): number | undefined {
    const rate = this.getRate(toCurrency);
    if (rate === undefined) return undefined;
    return amount * rate;
  }
}
