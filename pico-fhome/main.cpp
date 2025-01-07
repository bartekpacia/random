#include "pico/stdlib.h"
#include "lcd_display.hpp"

// Pico W devices use a GPIO on the WIFI chip for the LED,
// so when building for Pico W, CYW43_WL_GPIO_LED_PIN will be defined
#ifdef CYW43_WL_GPIO_LED_PIN
#include "pico/cyw43_arch.h"
#endif

#ifndef LED_DELAY_MS
#define LED_DELAY_MS 500
#endif

// Perform initialisation
int pico_led_init(void) {
#if defined(PICO_DEFAULT_LED_PIN)
    // A device like Pico that uses a GPIO for the LED will define
    // PICO_DEFAULT_LED_PIN so we can use normal GPIO functionality to turn the
    // led on and off
    gpio_init(PICO_DEFAULT_LED_PIN);
    gpio_set_dir(PICO_DEFAULT_LED_PIN, GPIO_OUT);
    return PICO_OK;
#elif defined(CYW43_WL_GPIO_LED_PIN)
    // For Pico W devices we need to initialise the driver etc
    return cyw43_arch_init();
#endif
}

// Turn the led on or off
void pico_set_led(bool led_on) {
#if defined(PICO_DEFAULT_LED_PIN)
    // Just set the GPIO on or off
    gpio_put(PICO_DEFAULT_LED_PIN, led_on);
#elif defined(CYW43_WL_GPIO_LED_PIN)
    // Ask the wifi "driver" to set the GPIO on or off
    cyw43_arch_gpio_put(CYW43_WL_GPIO_LED_PIN, led_on);
#endif
}

int main() {
    gpio_init(9);
    gpio_init(15);

    // DB4, DB5, DB6, DB7, RS, E, character_width, no_of_lines
    LCDdisplay myLCD(24, 25, 26, 27, 21, 22, 16, 2);
    myLCD.init();
    myLCD.display_on();

    myLCD.clear();
    myLCD.cursor_on();
    myLCD.print("HELLO ");

    gpio_set_dir(9, GPIO_OUT);
    gpio_set_dir(15, GPIO_OUT);

    int rc = pico_led_init();
    hard_assert(rc == PICO_OK);
    while (true) {
        gpio_put(9, true);
        gpio_put(15, true);
        pico_set_led(true);
        sleep_ms(LED_DELAY_MS);
        pico_set_led(false);
        gpio_put(9, false);
        gpio_put(15, false);
        sleep_ms(LED_DELAY_MS);
    }
}
