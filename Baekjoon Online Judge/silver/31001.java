import java.io.*;
import java.util.*;

public class Main {
    static class Company {
        String group;
        String name;
        long price;
        long stocksOwned;

        public Company(String group, String name, long price) {
            this.group = group;
            this.name = name;
            this.price = price;
            this.stocksOwned = 0;
        }
    }
    static class Simulation{
        long money;
        Map<String, Company> companies = new HashMap<>();
        Map<String, List<Company>> groupMap = new HashMap<>();

        public Simulation(long money) {
            this.money = money;
        }
        public void addCompany(String G, String H, long P) {
            Company company = new Company(G, H, P);
            companies.put(H, company);
            groupMap.putIfAbsent(G, new ArrayList<>());
            groupMap.get(G).add(company);
        }

        public void buyStocks(String name, long buyQuantity) {
            // 1 A B : 회사 A의 주식을 B주 산다.
            Company company = companies.get(name);
            long cost = company.price * buyQuantity;
            // 보유 현금으로 B주를 전부 구매할 수 있는 경우에만 산다.
            if (money >= cost) {
                money -= cost;
                company.stocksOwned += buyQuantity;
            }
        }
        public void sellStocks(String name, long sellQuantity) {
            // 2 A B : 회사 A의 주식을 B주 판다.
            Company company = companies.get(name);
            // 보유 주식보다 구매 갯수가 많아도 판매한다.
            if (company.stocksOwned < sellQuantity) {
                sellQuantity = company.stocksOwned;
            }
            long revenue = company.price * sellQuantity;
            money += revenue;
            company.stocksOwned -= sellQuantity;
        }
        public void updatePrice(String name, long diff) {
            // 3 A C : A의 주가가 C원 만큼 변동된다.
            Company company = companies.get(name);
            company.price += diff;
        }
        public void updateGroupPrice(String group, long diff) {
            // 4 D C : D 그룹에 속하는 회사들의 주가가 C원 변동된다.
            List<Company> companyList = groupMap.get(group);
            for (Company company : companyList) {
                company.price += diff;
            }
        }
        public void updateGroupPricePercent(String group, long percent) {
            // 5 D E : D 그룹에 속하는 회사들의 주가가 E% 변동된다.
            List<Company> companyList = groupMap.get(group);
            for (Company company : companyList) {
                company.price = (company.price * (100 + percent)) / 100;
                // 5번 메뉴의 경우 변동률에 따라 회사들의 주가를 반영하고 난 뒤 일의 자리에서 버림한다.
                company.price -= company.price % 10;
            }
        }
        public long calcAllStocksOwned2Money() {
            long total = money;
            for (Company company : companies.values()) {
                total += company.price * company.stocksOwned;
            }
            return total;
        }
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final long N = Integer.parseInt(input[0]);
        final long M = Integer.parseInt(input[1]);
        final long Q = Integer.parseInt(input[2]);
        Simulation simulation = new Simulation(M);

        for (long i = 0; i < N; ++i) {
            input = br.readLine().split(" ");
            String G = input[0];
            String H = input[1];
            long P = Integer.parseInt(input[2]);
            simulation.addCompany(G, H, P);
        }

        // Solve
        for (long i = 0; i < Q; ++i) {
            input = br.readLine().split(" ");
            int type = Integer.parseInt(input[0]);
            switch (type) {
                case 1:
                    simulation.buyStocks(input[1], Integer.parseInt(input[2]));
                    break;
                case 2:
                    simulation.sellStocks(input[1], Integer.parseInt(input[2]));
                    break;
                case 3:
                    simulation.updatePrice(input[1], Integer.parseInt(input[2]));
                    break;
                case 4:
                    simulation.updateGroupPrice(input[1], Integer.parseInt(input[2]));
                    break;
                case 5:
                    simulation.updateGroupPricePercent(input[1], Integer.parseInt(input[2]));
                    break;
                case 6:
                    System.out.println(simulation.money);
                    break;
                case 7:
                    System.out.println(simulation.calcAllStocksOwned2Money());
                    break;
            }
        }
    }
}
