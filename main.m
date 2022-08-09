#import <Foundation/Foundation.h>
#import "peertalk/Peertalk.h"
#import "Delegate.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSLog(@"%@\n", @"Hello, World!");

        [PTUSBHub sharedHub];

        Delegate *delegate = [[Delegate alloc] init];
        [delegate doSomething:@"Hello, World!"];

        PTChannel *channel = [PTChannel channelWithDelegate:delegate];
    }
}
