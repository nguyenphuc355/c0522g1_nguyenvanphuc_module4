package currency.service.impl;

import currency.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public double calculate(double money) {
        return money * 23000;
    }
}
