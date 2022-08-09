#import <Foundation/Foundation.h>
#import "peertalk/PTChannel.h"

@interface Delegate : NSObject<PTChannelDelegate>
- (void)doSomething:(NSString*)data;
- (void)connectToUSBDevice;
@end
