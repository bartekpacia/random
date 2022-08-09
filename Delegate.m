#import <Foundation/Foundation.h>
#import "Delegate.h"

// compile with:
// clang -o main main.m Delegate.m peertalk/PTChannel.m peertalk/PTProtocol.m peertalk/PTUSBHub.m -framework Foundation

@implementation Delegate
- (void)doSomething:(NSString*)data {
    NSLog(@"Okay, doing something with %@", data);
}
@end
