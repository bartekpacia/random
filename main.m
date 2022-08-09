#import <Foundation/Foundation.h>
#import "peertalk/Peertalk.h"
#import "Delegate.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSLog(@"%@\n", @"Hello, World!");

        [PTUSBHub sharedHub];

        Delegate *delegate = [Delegate new];
        [delegate doSomething:@"Hello, World!"];
    }
}
