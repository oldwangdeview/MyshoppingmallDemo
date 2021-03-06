package com.shoppingmall.cdz.contans;

/**
 * Author wangshifu
 * Dest  ${TODO}
 */

public interface AliPayContant {
   /**支付吧网关*/
    String  AliPay_GATEWAY="https://openapi.alipaydev.com/gateway.do";
    /**商户私钥私钥*/
    String ALIPAY_PRIVATEKEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDU49oVhNOOLyigns/8aMsPqRPsYCq9EYR0EzqbP0Q+MkcwUArWLYPBTiX90LJJlSeull8g0I21LN7tcHAycW+LlEOczeHTYpTOs8DC7NDFTccqb/DlHz5SsPrs4E+EoRfeMUc0YPhbow2xa1kLQldqZYhFS2QhoMmtFXiNM8+DccoTYrRhhTDGk9SO8Z8iUZ+cUFtxRhn1zGKLuyws1xANhqkVLS3rZ2SXWtQTbP0T7VcN8kN55jKxiatMi3+wi7e1Qubc4TQuPM1i38hNKbTCh/dyCFZJNaDJO5djhAQJUsWRytM2UVlt3HnKWaa2ZruyuDNvO2vEDeBci+/tzUdfAgMBAAECggEBALvboGsSvbgfByPNYE0kj+Nu2KTiK3SRi6b9/N5X0rlrloQcbaOXoEco1b+GtHzYAJ9AFAuZ3SI9yS4O5QKuNLcfixZIWvk0aYmI9xVK8eLZgmGBTDpy+oTvpUz3l1O675vjMikXVLFQTdn8lyOnVAoQNFKpd19xSeXRJ4K6cGhUmcVk/9OOQxs7t/vGZZG9Qy/Q0QeBvVtSR87DvXRjg3xvHHXxxwxaC39/+DK+tLZLfHQll85GcM5gWUoogcJRP00Duure4QbnBC1ZYny0Mte2j6H3OiPzMRYlB2imHS/gmu0w/EV3ky3zhNY7bpmKMel2LrkG3JNY6e1vNNmtx9ECgYEA8EQ+HWfUeTO9ocXmGPCrj3ABf7hgGscleQg+h/Y2LbAViOKjkjnN9CkqVNm/beCT6zMyMotSWlZYEOV8JthDhOsQF5iAT/ya2DqD4tnWHhBE+4ljBkSNsTBWUvfk+VuArGKbD7X3PNvKHUP+pBZZNAcbSJMAi2CtyRKotuVPgskCgYEA4tStZCit4q/3Ee2hQ62I6erRzhCCEt4R8vE43irE/SfT3RRlJ4cmwxDEN43TS36Mjz9dRFt+w87u8EqbJ9Z1TJnImtEnEOMASkN7ti6QTYBadQ08xpmAhT+5SkGWZstG3dPlMsy3sGJkpm8YsvwWz4xOlhe2mZGtJ25k2ApaJOcCgYBwph5VXSQSe37ShV2/nb9iLgqV3lU42Nwp5gKjbn2yaBeAqXo1ieKVMmPFip4lHyFbKhLD/exrrIX3zhCqicUGYcuWtIqcdfwHm0/QoX+xcsFVCfIisyuXwukGV3HEs/EdYdH/yLoVj5swo3uVZWEHcrmJCls7/eUdHCF8NwFTeQKBgDlDmdZ8UpG0/Lng9OJiD/uF1ZuhHUVoHL3pWgL0ZzDF+j2I5ZSaERYTyIWB34LimtebFo+oTZNfTYEKRKtE/+3rsPIstSEVPcCB0tyGWtXF/pAoXFyC6ig5kyyE7FRdIzHjSayOdB0qaeB+kYy2CYgyErDfobCZT05yFzFXQ7SnAoGBAIWjul+xQO5LI+vNd1/zZqvEjIfV1AT4ePnShJjZqTDcS6N74MN49Q9dwC6vtgYonOLf0NvkWjxjFV2WHI+eY8W5I29CMqT4h3dMmiVwr98nOvQFs1JcfHR+tR8ba8olBl2DpossVxK8OQo/O1g6QT8JqNK2fvOlLaG45wI4PvDh";

    /**
     * 支付宝公钥
     */
    String ALIPAY_PUBLICKEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArB34SZubuIhcW41fAq9+QjCUM7A/N8pypGYtWDBIC3dgcw+4/nY4yPsNkQbx6rNAI9ZIaibQBZt3OzqqmfAMOzJ9hbML4a6+AKOdV9vHWCaZKsIJO6P2PaDyimlrkm+v6hZxy6sAXY/t7Y9umw6EjLn1EP2+iXSrKsIHkODSEXYutP/mpIQD6Vip/C9l05TFn5tdgZ3Wvm9jhfQAGC0R4X4kdbpsyU8uqd9cdQ3Skvb2jlpz6pJg9ySdxFyEb95/KKgUAuXHJHEdQA1bQGogWeJ1xfwx6pAd5DcuYxKKD9jm4YzBBVWe9xylbFehDojaytU8gnJmi1xt2jw86dRjEQIDAQAB";
    /**appid*/
    String APPID ="2016082600317270";


    String orderInfo="charset=utf-8&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.01%22%2C%22subject%22%3A%22%E8%AE%A2%E5%8D%95%E6%94%AF%E4%BB%98%22%2C%22body%22%3A%22wangxiaoming%22%2C%22out_trade_no%22%3A%2220180206175755alipay%22%7D&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Ftfinoray.vicp.io%2Fpay%2Fnotify&app_id=2016082600317270&sign_type=RSA2&version=1.0&timestamp=2018-02-06+17%3A57%3A55&sign=X5ig3kFcwxz68mL0bP8xxQEBWJRnoHjp7Aw5AXVejXavSel%2FDbd6XgZD0%2FtIep2p2%2BVLWmfJpRZJSQrVKE7%2FBh2rm8oOOwNAwqOR%2B3RYym3%2FgttEp4Nt4jk6sArz4whjTcixsmvxawyrNgpJeISKgGiFpm4mAalp61hswYf6seJXiVvyYKF39ZUbV4rB6z8xjmdbt7hveIr%2FJFn3lyOQ7rIf3Iuwm22FakC3tHnN0331zOEPlH9B1sJj3Vw%2FmZ0UHsJYsmdzRJI%2FkUmXEuwU98%2FExOyUpMoMxi6mT7GAv5IpRbSY5lLT%2FJehIy1f85jFgqa1tXCNom44e8bzDxxvkQ%3D%3D";
        }
